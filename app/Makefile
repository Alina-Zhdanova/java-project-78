.DEFAULT_GOAL := build-run

run-dist:
	./build/install/app/bin/app /Users/alinazdanova/java-project-71/app/src/test/resources/fixtures/file1.json /Users/alinazdanova/java-project-71/app/src/test/resources/fixtures/file2.json

setup:
	./gradlew wrapper --gradle-version 8.5

clean:
	./gradlew clean

build:
	./gradlew clean build

install:
	./gradlew clean install

run:
	./gradlew run

test:
	./gradlew test

report:
	./gradlew jacocoTestReport

lint:
	./gradlew checkstyleMain

check-deps:
	./gradlew dependencyUpdates -Drevision=release


build-run: build run

.PHONY: build test
.PHONY: test
