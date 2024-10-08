CREATE DATABASE TRAITEUR_API.

CREATE TABLE CLIENT (
       ID integer primary key not null AUTO_INCREMENT,
       NOM varchar (50) UNIQUE,
       PRENOM varchar(50) UNIQUE,
       ADRESSE varchar(250)
       EMAIL varchar (50) UNIQUE


       );

CREATE TABLE PRODUITS (
      ID integer primary key not null AUTO_INCREMENT,
      TITLE varchar (50),
      DESCRIPTION varchar(250),
      IMAGEURL varchar(250),
      TYPE varchar(50)

);
CREATE TABLE UTILISATEUR (
                        ID integer primary key not null AUTO_INCREMENT,
                        NOM varchar (50),
                        EMAIL varchar(250),
                        MDP varchar(250),
                        ROLE varchar(50)

);
CREATE TABLE ROLE (
                           ID integer primary key not null AUTO_INCREMENT,
                           LIBELLE varchar (50)


);


