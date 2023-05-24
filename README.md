# PasswordManager

PasswordManager is password manager capable of holding multiple users.

This version is still in continous development.
> Developed Tiago Marques

<img src="https://j.gifs.com/qj5Dv2@large.gif?download=true">

- [PasswordManager](#passwordmanager)
  - [Requirements](#requirements)
  - [Running](#running)

## Requirements
  
PasswordManager uses shell scripts and docker images to run 
* Linux distro
* Docker Engine

## Running

1. 
```
sh 01_setup.sh
\\ This will download and run an alpine image that runs a PostgreSQL server 
```

2.
```
sh 02_run.sh
\\ This will build and run password-manager
```
