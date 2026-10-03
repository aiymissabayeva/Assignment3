# Assignment 3 — Bridge Design Pattern

## Chosen Option
Option D — Remote Controls

## Project Structure
- Abstraction: Remote
- Refined Abstractions: BasicRemote, QuietRemote
- Implementor: Device
- Concrete Implementations: TvDevice, RadioDevice, ProjectorDevice

## How to Compile

javac --release 17 -encoding UTF-8 -d out "@sources.txt"

## How to Run

java -cp out Main --demo

## Expected Result

The demo runs tests T1–T7.

Expected final line:

SUMMARY: 7/7 PASS

## Extension

BASE_COMMIT: 0e050ac

ProjectorDevice was added after the base commit as the third implementation (I3).

The extension.diff file contains the changes from BASE_COMMIT to the final version.
