#### 1.gzip/gunzip指令
基本语法:

1.gzip 【文件名】    用来压缩文件，只能将文件压缩为 .gz 格式

2.gunzip 【文件.gz】    解压gz格式的文件

要注意，使用gzip指令压缩之后，是不会保留原文件的

#### 2.zip/unzip指令
##### 这个命令是在项目打包发布的时候使用的，很常用
基本语法:

1. zip 【选项】 【压缩包的名称】 【要压缩的内容】    常用为 zip -r :递归压缩目录

2. unzip 【选项】 【要解压的文件】  常用为 unzip -d 【目标文件夹】 【压缩包】:指定解压后文件存放的目录

#### 3.打包指令tar
##### tar指令是打包指令，最后打包生成的文件是.tar.gz文件，这个命令也是工作中经常用到的
基本语法: tar 【选项】 【压缩文件名.tar.gz】 【要打包的内容可以有多个】    打包目录，压缩后的文件格式为tar.gz

选项
1. -c :产生tar打包文件
2. -v :显示详细信息
3. -f :只当压缩后的文件名
4. -z :打包同时压缩
5. -x :解包.tar文件

##### 所以一般来说，打包是 tar -zcvf 【压缩文件名.tar.gz】 【要打包的内容】，选项组合使用
##### 解压是 tar -zxvf 【压缩文件名.tar.gz】 ,这会解压到当前目录下
##### 如果要解压的指定目录，那么使用 tar -zxvf 【压缩文件名.tar.gz】 -C 【指定目录文件夹】