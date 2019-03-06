package com.ptaku.jascms.config;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableJpaRepositories("com.ptaku.jascms.repository")
@EnableTransactionManagement
public class DatabaseConfig {
}
