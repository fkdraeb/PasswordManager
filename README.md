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
* Maven

## Running

1. Download and run an alpine image that runs a PostgreSQL server 
```
sh 01_setup.sh
```

2. Building and running PasswordManager
```
sh 02_run.sh
```

3. Access the webpage
```
localhost:8090
```
