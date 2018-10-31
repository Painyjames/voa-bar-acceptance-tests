#! /bin/sh

sbt -Denvironment=qa -Dbrowser=chrome clean 'test-only voabar.runner.Runner'
