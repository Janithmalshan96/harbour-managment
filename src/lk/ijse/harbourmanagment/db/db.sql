
DROP DATABASE HARBOURBOAT;

CREATE DATABASE HARBOURBOAT;

USE HARBOURBOAT;

CREATE TABLE Owner(
    oid varchar(10)NOT NULL,
    name varchar(60),
    address varchar(100),
	nic varchar(13),
	contact varchar(13),
    CONSTRAINT PRIMARY KEY(oid)
);

CREATE TABLE Boat(
    bid varchar(10)NOT NULL,
	name varchar(60),
	length decimal(10,2),
	colour varchar(20),
	boat_type varchar(20),
    CONSTRAINT PRIMARY KEY(bid)
);

CREATE TABLE Fisherman(
    fid varchar(10)NOT NULL,
	name varchar(60),
    address varchar(100),
	nic varchar(13),
	contact varchar(13),
    CONSTRAINT PRIMARY KEY(fid)
);

CREATE TABLE FBDetail(
fbid int NOT NULL AUTO_INCREMENT,
bid varchar(10),
fid varchar(10),
CONSTRAINT PRIMARY KEY(fbid),
CONSTRAINT FOREIGN KEY(bid) REFERENCES Boat(bid)
ON UPDATE CASCADE ON DELETE CASCADE,
CONSTRAINT FOREIGN KEY(fid) REFERENCES Fisherman(fid)
ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE OBDetail(
obid int NOT NULL AUTO_INCREMENT,
oid varchar(10),
bid varchar(10),
CONSTRAINT PRIMARY KEY(obid),
CONSTRAINT FOREIGN KEY(oid) REFERENCES Owner(oid)
ON UPDATE CASCADE ON DELETE CASCADE,
CONSTRAINT FOREIGN KEY(bid) REFERENCES Boat(bid)
ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Schedule(
sid varchar(10)NOT NULL,
start_date date,
end_date date,
count int,
CONSTRAINT PRIMARY KEY(sid)
);

CREATE TABLE Registration(
rid varchar(10)NOT NULL,
bid varchar(10),
r_date date,
CONSTRAINT PRIMARY KEY(rid),
CONSTRAINT FOREIGN KEY(bid) REFERENCES Boat(bid)
ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE RSDetail(
rsid int NOT NULL AUTO_INCREMENT,
rid varchar(10),
sid varchar(10),
CONSTRAINT PRIMARY KEY(rsid),
CONSTRAINT FOREIGN KEY(rid) REFERENCES Registration(rid)
ON UPDATE CASCADE ON DELETE CASCADE,
CONSTRAINT FOREIGN KEY(sid) REFERENCES Schedule(sid)
ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Payment(
pid varchar(10)NOT NULL,
rid varchar(10) ,
amount decimal(10,2),
p_date date,
CONSTRAINT PRIMARY KEY(pid),
CONSTRAINT FOREIGN KEY(rid) REFERENCES Registration(rid)
ON UPDATE CASCADE ON DELETE CASCADE
);