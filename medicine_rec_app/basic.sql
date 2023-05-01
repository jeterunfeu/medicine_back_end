create sequence medi_member_seq;
create sequence medicine_seq;
create sequence show_sign_seq;
create sequence survey_seq;
create sequence personal_history_seq;
create sequence review_seq;
create table medi_member (
    membernum           number                  primary key,
   memberid         varchar2(20)         unique,      --사용자 식별ID. 유일한 값. 문자열 20byte.
   memberpw         varchar2(100)         not null,         --로그인할때 비밀번호. 필수. 문자열 100byte(becuase_암호화코드).
   membername         varchar2(30)         not null,         --사용자 이름
   email            varchar2(50),                        --이메일 주소
   phone            varchar2(50),                        --전화번호
   address            varchar2(200),                        --집 주소
   enabled            number(1)            default 1 not null,
                  constraint enabled_check check(enabled in (0, 1)),            
                     --계정상태. 숫자 1자리. 1은 사용가능(기본값), 0은 사용불가능 아이디. 데이터무결성(check로 0,1만)
   rolename         varchar2(20)         default 'ROLE_USER' not null,         
                     --사용자 종류. 기본값은 'ROLE_USER'. 필수항목.
                  constraint rolename_check check(rolename in ('ROLE_USER', 'ROLE_ADMIN'))         
                     --'ROLE_USER', 'ROLE_ADMIN'중 하나
);

create table medicine (
    mednum              number                  primary key,
    medname             varchar2(100)           unique,
    medco               varchar2(100)           not null,
    price               number                  not null,
    takemed             varchar2(2000),               
    medcycle            number                  default 3 not null,
    ingredient          varchar2(2000),
    note                varchar2(2000)                default null
);

create table show_sign (
    signnum             number                  primary key,
    signpart            varchar2(100)           not null,
    signfirst           varchar2(1000)                not null,
    signsecond          varchar2(1000)                not null,
    mednum              number                  references medicine(mednum)
);

create table survey (
    surveynum           number                  primary key,
    question            varchar2(2000),
    truenum             number,
    falsenum            number,
    signnum             number
);

create table presonal_history (
    historynum          number                  primary key,
    membernum           number                  references medi_member(membernum),
    signnum             number                  references show_sign(signnum),
    mednum              number                  references medicine(mednum),
    inputdate           date                    default sysdate
);

create table review (
    reviewnum           number                  primary key,
    contents            varchar2(2000)                not null,
    evaluate            number                  not null,
    mednum              number                  references medicine(mednum),
    membernum           number                  references medi_member(membernum),
    inputdate           date                    default sysdate
);

insert into medi_member(membernum, memberid, memberpw,membername, email, phone, address) values(medi_member_seq.nextval, 'aaa', '{bcrypt}$2a$10$fVWK.WZHd7jtio7rp..IWeAPex8Hus3VqFTcNtbghoa3X6wi4x7y2', 'test','test@gmail.com','010-1111-2222','광주무역회관');
insert into medicine(mednum, medname, medco, price, takemed,medcycle,ingredient,note) values(medicine_seq.nextval, '타이레놀','한국존슨앤드존슨',3000,'경구투여',3,'아세트아미노펜',null);
insert into medicine(mednum, medname, medco, price, takemed,medcycle,ingredient,note) values(medicine_seq.nextval, '타세놀','부광약품',3000,'경구투여',4,'아세트아미노펜','12세이상');
insert into medicine(mednum, medname, medco, price, takemed,medcycle,ingredient,note) values(medicine_seq.nextval, '펜콜아정','명문제약',3000,'경구투여',4,'아세트아미노펜','12세이상');
insert into medicine(mednum, medname, medco, price, takemed,medcycle,ingredient,note) values(medicine_seq.nextval, '판피린큐','동아제약',3000,'경구투여',4,'아세트아미노펜','12세이상');
insert into medicine(mednum, medname, medco, price, takemed,medcycle,ingredient,note) values(medicine_seq.nextval, '판콜에스','동화약품',3000,'경구투여',4,'아세트아미노펜','12세이상');
insert into show_sign(signnum, signpart, signfirst,signsecond,mednum) values(show_sign_seq.nextval, '머리','두통','두통',1);
insert into show_sign(signnum, signpart, signfirst,signsecond,mednum) values(show_sign_seq.nextval, '머리','두통','두통',2);
insert into show_sign(signnum, signpart, signfirst,signsecond,mednum) values(show_sign_seq.nextval, '머리','두통','두통',3);
insert into show_sign(signnum, signpart, signfirst,signsecond,mednum) values(show_sign_seq.nextval, '머리','어지럼증','어지럼증',4);
insert into show_sign(signnum, signpart, signfirst,signsecond,mednum) values(show_sign_seq.nextval, '머리','어지럼증','어지럼증',5);
insert into survey(surveynum, question, truenum,falsenum,signnum) values(survey_seq.nextval, '머리가 아프십니까?', 2, 3, null);
insert into survey(surveynum, question, truenum,falsenum,signnum) values(survey_seq.nextval, null, null, null, 1);
insert into survey(surveynum, question, truenum,falsenum,signnum) values(survey_seq.nextval, null, null, null, 4);