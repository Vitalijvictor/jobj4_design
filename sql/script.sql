fauna script inserts:

insert into fauna(name, avg_age, discovery_date) values ('Monkey', 11, '1798-11-28');
insert into fauna(name, avg_age, discovery_date) values ('Bear', 8, '1398-10-02');
insert into fauna(name, avg_age, discovery_date) values ('Zebra', 16, '1698-09-12');
insert into fauna(name, avg_age, discovery_date) values ('Cut fish', 3, '1100-04-17');
insert into fauna(name, avg_age, discovery_date) values ('Bacillus permians', 25000, '1956-12-02');
insert into fauna(name, avg_age, discovery_date) values ('Xestospongia muta', 50000 , null);

select * from fauna where name like '%fish';
select * from fauna where (avg_age >=10000) and (avg_age<=25000);
select * from fauna where discovery_date = null;
select * from fauna where discovery_date <'1950-00-0';

