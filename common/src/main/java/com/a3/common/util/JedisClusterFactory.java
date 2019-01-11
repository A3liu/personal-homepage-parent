package com.a3.common.util;

import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.core.io.Resource;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

//通过工厂模式创建JedisCluster对象
public class JedisClusterFactory implements FactoryBean<JedisCluster>{
	
	private Resource propertySource; //表示注入properties文件
	private JedisPoolConfig poolConfig; //注入池对象
	private String redisNodePrefix;		//定义redis节点的前缀
	
	@Override
	public JedisCluster getObject() throws Exception {
		Set<HostAndPort> nodes = getNodes();  //获取节点信息
		JedisCluster jedisCluster = 
				new JedisCluster(nodes, poolConfig);
		return jedisCluster;
	}
	//获取redis节点Set集合
	public Set<HostAndPort> getNodes(){
		//1.准备Set集合
		Set<HostAndPort> nodes = new HashSet<HostAndPort>();
		//2.创建property对象
		Properties properties = new Properties();
		try {
			
			properties.load(propertySource.getInputStream());
			//2.从配置文件中遍历redis节点数据
			for (Object key : properties.keySet()) {
				String keyStr = (String) key;
				//获取redis节点数据
				if(keyStr.startsWith(redisNodePrefix)){
					//IP:端口
					String value = properties.getProperty(keyStr);
					String[] args = value.split(":");
					HostAndPort hostAndPort = new HostAndPort(args[0],Integer.parseInt(args[1]));
					nodes.add(hostAndPort);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nodes;
	}
	@Override
	public Class<?> getObjectType() {
		return JedisCluster.class;
	}
	@Override
	public boolean isSingleton() {
		return false;
	}
	public Resource getPropertySource() {
		return propertySource;
	}
	public void setPropertySource(Resource propertySource) {
		this.propertySource = propertySource;
	}
	public JedisPoolConfig getPoolConfig() {
		return poolConfig;
	}
	public void setPoolConfig(JedisPoolConfig poolConfig) {
		this.poolConfig = poolConfig;
	}
	public String getRedisNodePrefix() {
		return redisNodePrefix;
	}
	public void setRedisNodePrefix(String redisNodePrefix) {
		this.redisNodePrefix = redisNodePrefix;
	}
}
