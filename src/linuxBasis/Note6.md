#### 1.帮助指令
对一个指令不熟悉或者对指令参数需要查看的时候可以查看
##### man + 指令

#### 2.pwd
基本语法: pwd

就是显示当前工作目录的绝对路径

#### 3.ls
基本语法:ls 【选项】 【目录或者文件】

选项 -a:显示当前目录所有的文件和目录，包括隐藏的

选项 -l:以列表的方式显示信息

#### 4.cd
基本语法:cd 【参数】

可以切换盘符/指定目录

常用参数如下:

1. cd ~ 回到家目录

2. cd .. 回到当前目录的上一层目录

#### 5.mkdir
基本语法:mkdir 【选项】 要创建的目录名称

常用选项:

mkdir -p    用于创建多级目录

#### 6.rmdir
基本语法:rmdir 【选项】 要删除的空目录

##### 要注意，rmdir删除的是空目录，如果目录下有文件是无法删除的
##### 这个时候如果要删除非空目录，使用 rm -rf 指令才可以

#### 7.touch
基本语法:touch 【文件名】

用来创建文件

这个文件名要带格式的，并且可以一次性创建多个文件，用空格隔开即可

#### 8.cp
基本语法:cp 【选项】 【要拷贝的文件】 【目标文件夹】

可以将文件进行复制

选项:-r 递归复制整个文件夹

#### 9.rm
基本语法:rm 【选项】 【要删除的文件或者目录】

该指令用来移除文件或者目录

选项:

1.rm -r :递归删除整个文件夹

2.rm -f :强制删除，不会提示

一般常用就是 rm -rf