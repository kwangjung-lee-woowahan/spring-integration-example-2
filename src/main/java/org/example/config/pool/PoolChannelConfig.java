package org.example.config.pool;

import jakarta.annotation.PostConstruct;
import java.net.URL;
import java.util.Set;
import org.example.pool.PoolBlock;
import org.reflections.Reflections;
import org.reflections.scanners.Scanners;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.channel.ExecutorChannel;
import org.springframework.messaging.MessageChannel;
import org.springframework.web.context.support.GenericWebApplicationContext;

@Configuration
public class PoolChannelConfig {

  private final GenericWebApplicationContext context;

  public PoolChannelConfig(GenericWebApplicationContext context) {
    this.context = context;
  }

//  @Bean(name = "EchoBlock")
//  public MessageChannel echoBlock() {
//    return new DirectChannel();
//  }
//
//  @Bean(name = "PlusTwoBlock")
//  public MessageChannel plusTwoBlock() {
//    return new DirectChannel();
//  }
//
//  @Bean(name = "MultipleTwoBlock")
//  public MessageChannel multipleTwoBlock() {
//    return new DirectChannel();
//  }

//  @PostConstruct
//  public void registerCommandChannels() {
//    // 경로 찾기
//    URL url = ClasspathHelper.forClass(PoolBlock.class);
//    // 스캐너 등록
//    ConfigurationBuilder builder = new ConfigurationBuilder()
//        .setUrls(url)
//        .setScanners(Scanners.SubTypes);
//    // Reflections 객체 생성
//    Reflections reflections = new Reflections(builder);
//
//    Set<Class<? extends PoolBlock>> subTypes = reflections.getSubTypesOf(PoolBlock.class);
//    subTypes.forEach(aClass ->
//        context.registerBean(aClass.getSimpleName(), DirectChannel.class));
//  }
}
