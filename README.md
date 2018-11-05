# DateCalculation(日付計算アプリケーション)

## Overview
任意の日付に対して、計算式を元に日付計算を行うWebアプリケーション。

## Description
アプリケーションとしては画面から計算式の確認やシミュレーションが行える。
計算処理はAPI化されているため、外部呼出しも可。
計算を行う為の計算情報のみをDBに保持しており、計算情報は画面から登録することで利用できる。
計算結果は全てUTCで行われ、計算結果はYYYYMMDDで返す。

タイムゾーン対応はしておらず、またフォーマットについても対応していない。

## Requirement
SpringBoot 2.1.0.RELEASE
Thymeleaf 3.0.0.RELEASE

## Usage

## Install

## Licence

## Author

[koujienami](https://github.com/koujienami)