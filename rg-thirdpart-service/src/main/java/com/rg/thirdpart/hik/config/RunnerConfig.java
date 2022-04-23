package com.rg.thirdpart.hik.config;

import com.hikvision.artemis.sdk.config.ArtemisConfig;
import com.hikvision.artemis.sdk.constant.Constants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 *
 *
 * @author Harry
 * @date 2020/8/10 20:41
 */
@Configuration
public class RunnerConfig {

  public static  final String ARTEMIS_PATH = "/artemis";

  /**
   * 请求协议
   */
  private static String protocol;

  @Value("${hikvison.iot.host:117.86.0.219:56000}")
  private  void setHost( String host ) {
    ArtemisConfig.host = host;
    Constants.DEFAULT_TIMEOUT = 10000;
  }

  /**
   * 设置超时，默认是10秒
   * @param minSeconds
   */
  @Value("${hikvison.iot.timeout:10000}")
  private  void setTimeOut( Integer minSeconds ) {
    Constants.DEFAULT_TIMEOUT = minSeconds;
  }

  @Value("${hikvison.iot.appKey:29188646}")
  private  void setAppKey( String appKey ) {
    ArtemisConfig.appKey = appKey;
  }
  @Value("${hikvison.iot.appSecret:yPMZg7PMNhOcIQsHDTdl}")
  private  void setAppSecret( String appSecret ) {
    ArtemisConfig.appSecret = appSecret;
  }

  @Value("${hikvison.iot.protocol:https}")
  private void setProtocol( String protocol ) {
    RunnerConfig.protocol = protocol;
  }

  /**
   *
   * @return
   */
  public  static  String  getProtocol(){
    return RunnerConfig.protocol.concat("://");
  }

  public static String getArtemisPath() {
    return ARTEMIS_PATH;
  }
}
