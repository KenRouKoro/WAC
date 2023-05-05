package cn.korostudio.mc.wac.wacignite;

import cn.korostudio.mc.wac.common.WAC;
import com.google.inject.Inject;
import org.apache.logging.log4j.Logger;
import org.checkerframework.checker.nullness.qual.NonNull;
import space.vectrix.ignite.api.Platform;
import space.vectrix.ignite.api.event.Subscribe;
import space.vectrix.ignite.api.event.platform.PlatformInitializeEvent;
public class WACIgnite {
  public static Logger logger;
  private static Platform platform;

  public static Logger getLogger() {
    return logger;
  }

  @Inject
  public WACIgnite(final Logger logger,final Platform platform) {
    WACIgnite.logger = logger;
    WACIgnite.platform = platform;
  }
  @Subscribe
  public void onInitialize(final @NonNull PlatformInitializeEvent event) {
    WAC.init();

  }

  //public void onInitialize() {
  //
  //  }
}
