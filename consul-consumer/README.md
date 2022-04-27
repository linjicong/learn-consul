# Getting Started
1. 本地启动consul服务端
    $ consul agent -dev 
2. key/value菜单新增一个配置项(${test.a}),要不然会报错
    新增根目录(prefixes)->新增项目目录(default-context)->新增配置文件(data-key)
