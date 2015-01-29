#!/bin/bash

cd src && rmiregistry&
cd src && java PuzzleSolverServer $1
