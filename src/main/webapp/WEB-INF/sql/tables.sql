create table TestTask_Farmer (
	farmerId LONG not null primary key,
	companyName VARCHAR(75) null,
	organizationForm VARCHAR(75) null,
	inn VARCHAR(75) null,
	kpp VARCHAR(75) null,
	ogrn VARCHAR(75) null,
	regionId LONG,
	registrationDate VARCHAR(75) null,
	archiveStatus VARCHAR(75) null
);

create table TestTask_Farmers_Regions (
	farmerId LONG not null,
	regionId LONG not null,
	primary key (farmerId, regionId)
);

create table TestTask_Region (
	regionId LONG not null primary key,
	regionName VARCHAR(75) null,
	regionCode VARCHAR(75) null,
	archiveStatus VARCHAR(75) null
);