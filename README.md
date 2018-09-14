# MybatisPlus
SpringBoot整合MybatisPlus
#使用
$git clone https://github.com/TianPuJun/MybatisPlus.git
#CSDN
https://mp.csdn.net/postedit/82688150
###配置详解
#configLocation
类型：String
默认值：null
MyBatis 配置文件位置，如果您有单独的 MyBatis 配置，请将其路径配置到 configLocation 中。 
#mapperLocations
 类型：String[]
 默认值：[]
 MyBatis Mapper 所对应的 XML 文件位置，如果您在 Mapper 中有自定义方法（XML 中有自定义实现），需要进行该配置，告诉 Mapper 所对应的 XML 文件位置。
 #typeAliasesPackage
  类型：String
  默认值：null
  MyBaits 别名包扫描路径，通过该属性可以给包中的类注册别名，注册后在 Mapper 对应的 XML 文件中可以直接使用类名，而不用使用全限定的类名（即 XML 中调用的时候不用包含包名）。
#typeAliasesSuperType
 类型：Class<?>
 默认值：null
 该配置请和 typeAliasesPackage 一起使用，如果配置了该属性，则仅仅会扫描路径下以该类作为父类的域对象 。
 #typeHandlersPackage
  类型：String
  默认值：null
  TypeHandler 扫描路径，如果配置了该属性，SqlSessionFactoryBean 会把该包下面的类注册为对应的 TypeHandler。
  TypeHandler 通常用于自定义类型转换。
 #typeEnumsPackage
  类型：String
  默认值：null
  枚举类 扫描路径，如果配置了该属性，会将路径下的枚举类进行注入，让实体类字段能够简单快捷的使用枚举属性
 #checkConfigLocation Spring Boot
  类型：boolean
  默认值：false
  启动时是否检查 MyBatis XML 文件的存在，默认不检查。
 #executorType 
  类型：ExecutorType
  默认值：sample
  通过该属性可指定 MyBatis 的执行器，MyBatis 的执行器总共有三种：
  #
  ExecutorType.SIMPLE：该执行器类型不做特殊的事情，为每个语句的执行创建一个新的预处理语句（PreparedStatement）
  ExecutorType.REUSE：该执行器类型会复用预处理语句（PreparedStatement）
  ExecutorType.BATCH：该执行器类型会批量执行所有的更新语句
 #configurationProperties
  类型：Properties
  默认值：null
  指定外部化 MyBatis Properties 配置，通过该配置可以抽离配置，实现不同环境的配置部署。
 ###进阶配置 
  ##本部分的配置大都为 MyBatis 原生支持的配置，这意味着您可以通过 MyBatis XML 配置文件的形式进行配置。
  ##configuration
  类型：Configuration
  默认值：null
  原生 MyBatis 所支持的配置，具体请查看 进阶配置
  #aggressiveLazyLoading
   类型：boolean
   默认值：true
   当设置为 true 的时候，懒加载的对象可能被任何懒属性全部加载，否则，每个属性都按需加载。需要和 lazyLoadingEnabled 一起使用。
  #autoMappingBehavior
   类型：AutoMappingBehavior
   默认值：partial
   MyBatis 自动映射策略，通过该配置可指定 MyBatis 是否并且如何来自动映射数据表字段与对象的属性，总共有 3 种可选值：
   AutoMappingBehavior.NONE：不启用自动映射
   AutoMappingBehavior.PARTIAL：只对非嵌套的 resultMap 进行自动映射
   AutoMappingBehavior.FULL：对所有的 resultMap 都进行自动映射
  #autoMappingUnknownColumnBehavior
   类型：AutoMappingUnknownColumnBehavior
   默认值：NONE
   MyBatis 自动映射时未知列或未知属性处理策略，通过该配置可指定 MyBatis 在自动映射过程中遇到未知列或者未知属性时如何处理，总共有 3 种可选值：
   AutoMappingUnknownColumnBehavior.NONE：不做任何处理 (默认值)
   AutoMappingUnknownColumnBehavior.WARNING：以日志的形式打印相关警告信息
   AutoMappingUnknownColumnBehavior.FAILING：当作映射失败处理，并抛出异常和详细信息
  #cacheEnabled
   类型：boolean
   默认值：true
   全局地开启或关闭配置文件中的所有映射器已经配置的任何缓存，默认为 true。
  #callSettersOnNulls
   类型：boolean
   默认值：false
   指定当结果集中值为 null 的时候是否调用映射对象的 Setter（Map 对象时为 put）方法，通常运用于有 Map.keySet() 依赖或 null 值初始化的情况。
   
   通俗的讲，即 MyBatis 在使用 resultMap 来映射查询结果中的列，如果查询结果中包含空值的列，则 MyBatis 在映射的时候，不会映射这个字段，这就导致在调用到该字段的时候由于没有映射，取不到而报空指针异常。
   
   当您遇到类似的情况，请针对该属性进行相关配置以解决以上问题。
   
   ## WARNING
   
   基本类型（int、boolean 等）是不能设置成 null 的。
  #configurationFactory
   类型：Class<?>
   默认值：null
   指定一个提供 Configuration 实例的工厂类。该工厂生产的实例将用来加载已经被反序列化对象的懒加载属性值，其必须包含一个签名方法static Configuration getConfiguration()。（从 3.2.3 版本开始）
 ###globalConfig
  类型：GlobalConfig
  默认值：null
  MyBatis-Plus 全局策略配置，具体请查看 全局策略配置
  ###全局策略配置
  #refresh
   类型：boolean
   默认值：false
   是否自动刷新 Mapper 对应的 XML 文件，默认不自动刷新。如果配置了该属性，Mapper 对应的 XML 文件会自动刷新，更改 XML 文件后，无需再次重启工程，由此节省大量时间。
   # WARNING
   该配置不建议在生产环境打开！
  #sqlParserCache
   类型：boolean
   默认值：false
   是否缓存 Sql 解析，默认不缓存。
  #sqlSession
   类型：SqlSession
   默认值：null
   单例重用 SqlSession。
  #sqlSessionFactory
   类型：SqlSessionFactory
   默认值：null
   缓存当前 Configuration 的 SqlSessionFactory。
  ### dbConfig
  类型：DbConfig
  默认值：null
  MyBatis-Plus 全局策略中的 DB 策略配置，具体请查看 DB 策略配置
  ##DB策略配置
  #capitalMode
   类型：boolean
   默认值：false
   是否开启大写命名，默认不开启
  #columnLike
   # columnUnderline
   # dbType
   # fieldStrategy
   # IdType
   # logicDeleteValue
   # logicNotDeleteValue
   # tablePrefix
   # tableUnderline
   
 ### 自动生成代码
 ##CodeGenerator类
 根据自己的环境修改配置类，策略配置中注释掉了父类连接，如有需要去掉注释即可
  
 