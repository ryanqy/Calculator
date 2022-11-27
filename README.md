# 简单计算机程序

本程序使用了命令模式/工厂模式，支持`redo` `undo` `clear`命令。

使用示例：
``` text
2 * 2
result: 4
redo
result: 8
undo
result: 4
undo
result: 2
undo
result: 0
undo
result: 0
redo
result: 0
clear
result: 0
12 / 6 * 3 + 1
result: 7
- 23
result: -16
+ 26
result: 10
redo
result: 36
redo
result: 62
redo
result: 88
redo
result: 114
redo
result: 140
undo
result: 114
undo
result: 88
undo
result: 62
clear
result: 0
undo
result: 0
12 * 133 - 2 * 23
result: 36662

```
