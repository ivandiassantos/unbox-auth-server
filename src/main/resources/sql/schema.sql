CREATE TABLE IF NOT EXISTS oauth_client_details (
client_id varchar(256) NOT NULL,
resource_ids varchar(256) NULL,
client_secret varchar(256) NULL,
scope varchar(256) NULL,
authorized_grant_types varchar(256) NULL,
web_server_redirect_uri varchar(256) NULL,
authorities varchar(256) NULL,
access_token_validity int4 NULL,
refresh_token_validity int4 NULL,
additional_information varchar(4096) NULL,
autoapprove varchar(256) NULL,
CONSTRAINT oauth_client_details_pkey PRIMARY KEY (client_id)
);

---------------------------------

CREATE SEQUENCE IF NOT EXISTS user_seq;
CREATE TABLE IF NOT EXISTS user (
	id INTEGER DEFAULT NEXTVAL('user_seq') NOT NULL,
	name CHARACTER VARYING(200) NOT NULL,
	username CHARACTER VARYING(200) NOT NULL,
	password CHARACTER VARYING(300) NOT NULL,
	registration_date DATE NOT NULL,
	PRIMARY KEY (id)
);