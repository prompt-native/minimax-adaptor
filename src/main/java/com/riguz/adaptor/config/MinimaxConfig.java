package com.riguz.adaptor.config;

import io.smallrye.config.ConfigMapping;

@ConfigMapping(prefix = "minimax")
public interface MinimaxConfig {
    String token();

    String groupId();
}
