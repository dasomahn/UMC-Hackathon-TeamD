CREATE TABLE `User` (
                        `idx`	bigint	auto_increment NOT NULL primary key,
                        `email`	text	NOT NULL,
                        `phoneNum`	bigint	NOT NULL,
                        `nickName`	varchar(20)	NOT NULL,
                        `profileImgUrl`	text	NULL,
                        `createdAt`	datetime	NOT NULL	DEFAULT CURRENT_TIMESTAMP,
                        `updatedAt`	datetime	NOT NULL	DEFAULT CURRENT_TIMESTAMP  ON UPDATE CURRENT_TIMESTAMP,
                        `status`	varchar(1)	NOT NULL	DEFAULT 'A'	COMMENT 'S 사용불가 (정지 등) N 휴면 D 탈퇴'
);

CREATE TABLE `SellPost` (
                            `idx`	bigint	auto_increment NOT NULL primary key,
                            `sellerIdx`	bigint	NOT NULL,
                            `buyerIdx`	bigint	NULL,
                            `regionIdx`	bigint	NOT NULL,
                            `type`	varchar(10)	NOT NULL	DEFAULT 'ACTIVE'	COMMENT 'BOOST RESERVED SOLD',
                            `title`	varchar(30)	NOT NULL,
                            `content`	text	NOT NULL,
                            `categoryIdx`	bigint	NOT NULL,
                            `isFree`	varchar(1)	NULL	DEFAULT 'N'	COMMENT 'Y',
                            `price`	int	NULL,
                            `wantNego`	varchar(10)	NOT NULL	DEFAULT 'N'	COMMENT 'Y',
                            `locationX`	float	NULL,
                            `locationY`	float	NULL,
                            `imgURL`	text	NULL,
                            `createdAt`	datetime	NOT NULL	DEFAULT CURRENT_TIMESTAMP,
                            `updatedAt`	datetime	NOT NULL	DEFAULT CURRENT_TIMESTAMP  ON UPDATE CURRENT_TIMESTAMP,
                            `status`	varchar(10)	NOT NULL	DEFAULT 'ACTIVE'	COMMENT 'DELETED HIDDEN'
);

CREATE TABLE `SellCategory` (
                                `idx`	bigint	auto_increment NOT NULL primary key,
                                `name`	varchar(10)	NULL,
                                `createdAt`	datetime	NOT NULL	DEFAULT CURRENT_TIMESTAMP,
                                `updatedAt`	datetime	NOT NULL	DEFAULT CURRENT_TIMESTAMP  ON UPDATE CURRENT_TIMESTAMP,
                                `status`	varchar(10)	NOT NULL	DEFAULT 'ACTIVE'	COMMENT 'DELETED'
);

CREATE TABLE `Portfolio` (
                             `idx`	int	auto_increment NOT NULL primary key,
                             `userIdx`	bigint	NOT NULL,
                             `postIdx`	bigint	NOT NULL,
                             `createdAt`	datetime	NOT NULL	DEFAULT CURRENT_TIMESTAMP,
                             `updatedAt`	datetime	NOT NULL	DEFAULT CURRENT_TIMESTAMP  ON UPDATE CURRENT_TIMESTAMP,
                             `status`	varchar(10)	NULL	DEFAULT 'ACTIVE'	COMMENT 'CANCELED'
);

CREATE TABLE `LocalPost` (
                             `postIdx`	bigint	auto_increment NOT NULL primary key,
                             `userIdx`	bigint	NOT NULL,
                             `regionIdx`	bigint	NOT NULL,
                             `content`	text	NOT NULL,
                             `categoryIdx`	bigint	NOT NULL,
                             `imgURL`	text	NULL,
                             `createdAt`	datetime	NOT NULL	DEFAULT CURRENT_TIMESTAMP,
                             `updatedAt`	datetime	NOT NULL	DEFAULT CURRENT_TIMESTAMP  ON UPDATE CURRENT_TIMESTAMP,
                             `status`	varchar(10)	NOT NULL	DEFAULT 'ACTIVE'	COMMENT 'DELETED HIDDEN'
);

CREATE TABLE `LocalCategory` (
                                 `idx`	bigint	auto_increment NOT NULL primary key,
                                 `name`	varchar(10)	NULL,
                                 `createdAt`	datetime	NOT NULL	DEFAULT CURRENT_TIMESTAMP,
                                 `updatedAt`	datetime	NOT NULL	DEFAULT CURRENT_TIMESTAMP  ON UPDATE CURRENT_TIMESTAMP,
                                 `status`	varchar(10)	NOT NULL	DEFAULT 'ACTIVE'	COMMENT 'DELETED'
);

CREATE TABLE `Region` (
                          `idx`	bigint	auto_increment NOT NULL primary key,
                          `name`	varchar(10)	NULL,
                          `locationInfo`	text	NULL	COMMENT '위치 정보 (경도 위동 등)',
                          `createdAt`	datetime	NOT NULL	DEFAULT CURRENT_TIMESTAMP,
                          `updatedAt`	datetime	NOT NULL	DEFAULT CURRENT_TIMESTAMP  ON UPDATE CURRENT_TIMESTAMP,
                          `status`	varchar(10)	NOT NULL	DEFAULT 'ACTIVE'	COMMENT 'DELETED'
);

CREATE TABLE `RegionSettings` (
                                  `idx`	bigint	auto_increment NOT NULL primary key,
                                  `userIdx`	bigint	NOT NULL,
                                  `region1`	bigint	NOT NULL,
                                  `region1verify`	int	NULL	COMMENT '위치 정보 (경도 위동 등)',
                                  `region2`	bigint	NOT NULL,
                                  `region2verify`	int	NOT NULL,
                                  `select`	int     NOT NULL	DEFAULT 1	COMMENT '1 또는 2 지역 설정',
                                  `createdAt`	datetime	NOT NULL	DEFAULT CURRENT_TIMESTAMP,
                                  `updatedAt`	datetime	NOT NULL	DEFAULT CURRENT_TIMESTAMP  ON UPDATE CURRENT_TIMESTAMP,
                                  `status`	varchar(10)	NOT NULL	DEFAULT 'ACTIVE'	COMMENT 'DELETED'
);

CREATE TABLE `LocalFavorite` (
                                 `idx`	int	auto_increment NOT NULL primary key,
                                 `userIdx`	bigint	NOT NULL,
                                 `postIdx`	bigint	NOT NULL,
                                 `createdAt`	datetime	NOT NULL	DEFAULT CURRENT_TIMESTAMP,
                                 `updatedAt`	datetime	NOT NULL	DEFAULT CURRENT_TIMESTAMP  ON UPDATE CURRENT_TIMESTAMP,
                                 `status`	varchar(10)	NULL	DEFAULT 'ACTIVE'	COMMENT 'CANCELED'
);

CREATE TABLE `LocalReaction` (
                                 `idx`	int	auto_increment NOT NULL primary key,
                                 `userIdx`	bigint	NOT NULL,
                                 `postIdx`	bigint	NOT NULL,
                                 `type`	varchar(10)	NOT NULL	COMMENT 'INTEREST LIKE',
                                 `createdAt`	datetime	NOT NULL	DEFAULT CURRENT_TIMESTAMP,
                                 `updatedAt`	datetime	NOT NULL	DEFAULT CURRENT_TIMESTAMP  ON UPDATE CURRENT_TIMESTAMP,
                                 `status`	varchar(10)	NULL	DEFAULT 'ACTIVE'	COMMENT 'CANCELED'
);

CREATE TABLE `LocalAnswer` (
                               `idx`	int	auto_increment NOT NULL primary key,
                               `userIdx`	bigint	NOT NULL,
                               `postIdx`	bigint	NOT NULL,
                               `type`	varchar(10)	NOT NULL	COMMENT 'REPLY COMMENT',
                               `createdAt`	datetime	NOT NULL	DEFAULT CURRENT_TIMESTAMP,
                               `updatedAt`	datetime	NOT NULL	DEFAULT CURRENT_TIMESTAMP  ON UPDATE CURRENT_TIMESTAMP,
                               `status`	varchar(10)	NULL	DEFAULT 'ACTIVE'	COMMENT 'CANCELED'
);

CREATE TABLE `SellCateInterest` (
                                    `idx`	bigint	auto_increment NOT NULL primary key,
                                    `userIdx`	bigint	NOT NULL,
                                    `cateIdx`	bigint	NOT NULL,
                                    `isCheck`	varchar(1)	NOT NULL	DEFAULT 'Y'	COMMENT 'N',
                                    `createdAt`	datetime	NOT NULL	DEFAULT CURRENT_TIMESTAMP,
                                    `updatedAt`	datetime	NOT NULL	DEFAULT CURRENT_TIMESTAMP  ON UPDATE CURRENT_TIMESTAMP,
                                    `status`	varchar(10)	NOT NULL	DEFAULT 'ACTIVE'	COMMENT 'DELETED'
);

CREATE TABLE `Review` (
                          `idx`	bigint	auto_increment NOT NULL primary key,
                          `postIdx`	bigint	NOT NULL,
                          `overall`	varchar(5)	NULL	DEFAULT 'GREAT'	COMMENT 'BAD GOOD GREAT',
                          `happy`	text	NULL	COMMENT '1, 2, 3, 4 식으로',
                          `content`	text	NULL,
                          `imgURL`	text	NULL,
                          `createdAt`	datetime	NULL	DEFAULT CURRENT_TIMESTAMP,
                          `updatedAt`	datetime	NOT NULL	DEFAULT CURRENT_TIMESTAMP  ON UPDATE CURRENT_TIMESTAMP,
                          `status`	varchar(10)	NULL	DEFAULT 'ACTIVE'	COMMENT 'DELETED HIDDEN'
);

ALTER TABLE `SellPost` ADD CONSTRAINT `FK_User_TO_SellPost_1` FOREIGN KEY (
                                                                           `sellerIdx`
    )
    REFERENCES `User` (
                       `idx`
        );

ALTER TABLE `SellPost` ADD CONSTRAINT `FK_User_TO_SellPost_2` FOREIGN KEY (
                                                                           `buyerIdx`
    )
    REFERENCES `User` (
                       `idx`
        );

ALTER TABLE `SellPost` ADD CONSTRAINT `FK_SellCategory_TO_SellPost_1` FOREIGN KEY (
                                                                                   `categoryIdx`
    )
    REFERENCES `SellCategory` (
                               `idx`
        );

ALTER TABLE `Portfolio` ADD CONSTRAINT `FK_User_TO_Portfolio_1` FOREIGN KEY (
                                                                             `userIdx`
    )
    REFERENCES `User` (
                       `idx`
        );

ALTER TABLE `Portfolio` ADD CONSTRAINT `FK_SellPost_TO_Portfolio_1` FOREIGN KEY (
                                                                                 `postIdx`
    )
    REFERENCES `SellPost` (
                           `idx`
        );

ALTER TABLE `LocalPost` ADD CONSTRAINT `FK_User_TO_LocalPost_1` FOREIGN KEY (
                                                                             `userIdx`
    )
    REFERENCES `User` (
                       `idx`
        );

ALTER TABLE `LocalPost` ADD CONSTRAINT `FK_Region_TO_LocalPost_1` FOREIGN KEY (
                                                                               `regionIdx`
    )
    REFERENCES `Region` (
                         `idx`
        );

ALTER TABLE `LocalPost` ADD CONSTRAINT `FK_LocalCategory_TO_LocalPost_1` FOREIGN KEY (
                                                                                      `categoryIdx`
    )
    REFERENCES `LocalCategory` (
                                `idx`
        );

ALTER TABLE `RegionSettings` ADD CONSTRAINT `FK_User_TO_RegionSettings_1` FOREIGN KEY (
                                                                                       `userIdx`
    )
    REFERENCES `User` (
                       `idx`
        );

ALTER TABLE `RegionSettings` ADD CONSTRAINT `FK_Region_TO_RegionSettings_1` FOREIGN KEY (
                                                                                         `region1`
    )
    REFERENCES `Region` (
                         `idx`
        );

ALTER TABLE `RegionSettings` ADD CONSTRAINT `FK_Region_TO_RegionSettings_2` FOREIGN KEY (
                                                                                         `region2`
    )
    REFERENCES `Region` (
                         `idx`
        );

ALTER TABLE `LocalFavorite` ADD CONSTRAINT `FK_User_TO_LocalFavorite_1` FOREIGN KEY (
                                                                                     `userIdx`
    )
    REFERENCES `User` (
                       `idx`
        );

ALTER TABLE `LocalFavorite` ADD CONSTRAINT `FK_LocalPost_TO_LocalFavorite_1` FOREIGN KEY (
                                                                                          `postIdx`
    )
    REFERENCES `LocalPost` (
                            `postIdx`
        );

ALTER TABLE `LocalReaction` ADD CONSTRAINT `FK_User_TO_LocalReaction_1` FOREIGN KEY (
                                                                                     `userIdx`
    )
    REFERENCES `User` (
                       `idx`
        );

ALTER TABLE `LocalReaction` ADD CONSTRAINT `FK_LocalPost_TO_LocalReaction_1` FOREIGN KEY (
                                                                                          `postIdx`
    )
    REFERENCES `LocalPost` (
                            `postIdx`
        );

ALTER TABLE `LocalAnswer` ADD CONSTRAINT `FK_User_TO_LocalAnswer_1` FOREIGN KEY (
                                                                                 `userIdx`
    )
    REFERENCES `User` (
                       `idx`
        );

ALTER TABLE `LocalAnswer` ADD CONSTRAINT `FK_LocalPost_TO_LocalAnswer_1` FOREIGN KEY (
                                                                                      `postIdx`
    )
    REFERENCES `LocalPost` (
                            `postIdx`
        );

ALTER TABLE `SellCateInterest` ADD CONSTRAINT `FK_User_TO_SellCateInterest_1` FOREIGN KEY (
                                                                                           `userIdx`
    )
    REFERENCES `User` (
                       `idx`
        );

ALTER TABLE `SellCateInterest` ADD CONSTRAINT `FK_SellCategory_TO_SellCateInterest_1` FOREIGN KEY (
                                                                                                   `cateIdx`
    )
    REFERENCES `SellCategory` (
                               `idx`
        );

ALTER TABLE `Review` ADD CONSTRAINT `FK_SellPost_TO_Review_1` FOREIGN KEY (
                                                                           `postIdx`
    )
    REFERENCES `SellPost` (
                           `idx`
        );