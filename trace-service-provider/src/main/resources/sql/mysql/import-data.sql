INSERT INTO trace.Organization (id, organization, name, createTime) VALUES ('default', 'default', 'default', '2017-10-10 16:57:59');
-- ----------------------------
-- Table data for UserEntity
-- ----------------------------
INSERT INTO trace.UserEntity (id, organization, roles, name, password, nickName, age, isMale, phone, email, address, createTime) VALUES ('admin', 'default', '', 'admin', 'admin', 'admin', 1, true, '15801632955', '1@1.com', '1', '2017-10-10 16:10:36');
-- ----------------------------
-- Table data for Role
-- ----------------------------
INSERT INTO trace.Role (id, organization, name, menus, createTime) VALUES ('ff8080815f055144015f0557b58e0001','default', 'admin', null, '2017-10-10 16:12:35');
-- ----------------------------
-- Table data for Reference
-- ----------------------------
INSERT INTO trace.Reference (id, targetName, targetId, sourceName, sourceId) VALUES ('ff8080815f055144015f05580af40006', 'Role', 'ff8080815f055144015f0557b58e0001', 'UserEntity', 'admin');


