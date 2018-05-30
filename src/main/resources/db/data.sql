delete from nho_user;
insert into nho_user values (0,'1','1');

delete from training_club;
insert into values (1, '训练营1', '欢迎来到训练营1', '张三');


--Story I5 专用 start--
insert into training_club values(1001,'训练营1001','欢迎来到训练营1001','李四');

insert into task_card values(1001,'任务卡1001','欢迎来到任务卡1001','https://img.zcool.cn/community/012db458fca3fda8012160f7f86d21.png@1280w_1l_2o_100sh.png',1001,0);
insert into task_card values(1002,'任务卡1002','欢迎来到任务卡1002','https://img.zcool.cn/community/012db458fca3fda8012160f7f86d21.png@1280w_1l_2o_100sh.png',1001,0);

insert into doc values(1001,'文档1001','https://info.thoughtworks.com/rs/thoughtworks2/images/agile_maturity_model.pdf',1001);
insert into doc values(1002,'文档1002','https://info.thoughtworks.com/rs/thoughtworks2/images/twebook-perspectives-estimation_1.pdf',1001);
insert into doc values(1003,'文档1003','http://info.thoughtworks.com/rs/thoughtworks2/images/agile_release_management_1.pdf',1002);
insert into doc values(1004,'文档1004','http://mrg.doc.ic.ac.uk/talks/2016/10/BETTY-ThoughtWorks/Scribble-ThoughtWorks.pdf',1002);

--Story I5 专用 end--


