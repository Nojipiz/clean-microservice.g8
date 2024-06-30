# Scala Multimodule Clean Architecture

This is a [Giter8](http://www.foundweekends.org/giter8/) template for bootstrap your new Scala project.

By default the application contains four modules:
* `core/domain/` Module for your domain
* `core/application/` Module for your application logic (depends on `core/domain/`)
* `core/infrastructure/` Module for your infrastructure (depends on `core/domain/`, `core/application/`)
* `mycustomservice/` Entry point of your application, (depends on `core/infrastructure/`, `core/domain/`, `core/application/`))

## Run the application
```shell
$ sbt new nojipiz/scala-clean-architecture.g8
$ cd clean-architecture-project
$ sbt
sbt:root> mycustomservice/run
```
