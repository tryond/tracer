[![Generic badge](https://img.shields.io/badge/build-passing-<COLOR>.svg)](https://shields.io/)
[![MIT license](https://img.shields.io/badge/License-MIT-blue.svg)](https://lbesson.mit-license.org/)

# Tracer

Tracer is a desktop application which tracks users' mouse behaviors through a series of button clicks.

## Description

Tracer is an application developed to capture users' mouse behaviors by having them click on a series of targets. Target locations are generated randomly for each session and have an associated sequence code. This code can be copied and pasted into the application in order to reproduce target locations so as to compare different users' behaviors in the same session. Mouse strokes are stored in an online database for use with our supplementary behavioral analysis tools.

## Motivation

Tracer is being developed alongside a suite of human-computer interaction research modules funded by Ore Technical Labs. All mouse strokes captured during any given session are uploaded to a database for analysis.

## Instructions

### Download

Download 'tracer.jar' release found [here](https://github.com/tryond/tracer/releases).

### Login/Register

Tracer requires that the user is logged in to ensure that the behavior collected is mapped to the correct user. If you are a first time user, please register with the application.

**Note: Please do not change users during a single session. Log out and log back in as another user. This is crucial to the integrity of the data collected.**. :+1:

![Login Image](res/tracer_images/login.png?raw=true "Image that shows login screen")
![Register Image](res/tracer_images/register.png?raw=true "Image that shows registration screen")

### Mouse Type Selection 

Mouse type selection asks the user to choose between a standard mouse and a trackpad (mainly found on laptops). 

**Note: Please use the mouse type selected for the duration of your use with the application. This is crucial to the integrity of the data collected.**. :+1:

![Mouse Select Image](res/tracer_images/mouse.png?raw=true "Image that shows mouse type selection")

### Starting Sequence

The sequence starts when the user clicks on the first target. The colored shapes are distractions meant to mimic real-world computer usage. 

![Sequence gif](res/tracer_images/animation.gif?raw=true "Animation that shows a typical sequence and results")

### Results

The results are displayed on-screen once the user finishes the sequence. The sequence id is shown in the bottom right-hand corner of the application window. This sequence code can be saved in order to recreate the sequence in the future. 

![Alt text](res/tracer_images/results.png?raw=true "Login Screen")

To start a new sequence, the user must either reset the current sequence, generate a random sequence, or enter a saved sequence code.

## Author

**Danny Tryon** - [tryond](https://github.com/tryond?tab=repositories)

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details

