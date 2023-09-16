# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

## [1.1.0-sa.1] - 2023-09-16

### Added

- [workflow deploy on branch deploy](.github/workflows/deploy_maven_package.yml)

### Changed

- fj-doc version set to 3.0.4
- fj-core-jee version set to 8.3.1-sa.1

### Security

- [resolved security issues by updating dependencies](https://github.com/fugerit-org/fj-doc-ent/security/dependabot/9)

## [1.0.0-sa.2] - 2023-09-05

### Added

- [Sonar cloud workflow](.github/workflows/sonarcloud-maven.yml)
- [Maven build workflow](.github/workflows/build_maven_package.yml)
- License, sonar cloud quality gate and mave repo version badges (#1)

### Changed

- Update fj-doc version to 2.0.2

## [0.5.0-rc.001] - 2023-07-02

### Added

- CHANGELOG.md (#1)
- fj-core-j2ee dependency

### Changed

- Update fj-doc version to 1.1.0-rc.001
- Minimum java required version for compiling : 11