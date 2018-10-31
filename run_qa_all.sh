#! /bin/sh

sbt -Denvironment=qa -Dbrowser=headless clean 'test-only voabar.runner.Runner'
