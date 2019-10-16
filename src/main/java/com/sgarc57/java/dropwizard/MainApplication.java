package com.sgarc57.java.dropwizard;

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import com.sgarc57.java.dropwizard.health.TemplateHealthCheck;
import com.sgarc57.java.dropwizard.resources.HelloWorldResource;

/**
 * Hello world!
 */
public class MainApplication extends Application<AppConfig> {

    public static void main(String[] args) throws Exception {
        if (args.length < 2) {
            new MainApplication().run(new String[]{"server", "config.yml"});
        } else {
            new MainApplication().run(args);
        }
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<AppConfig> bootstrap) {
        bootstrap.addBundle(new AssetsBundle("/dist/", "/"));
    }

    @Override
    public void run(AppConfig configuration,
                    Environment environment) {
        final HelloWorldResource resource = new HelloWorldResource(
                configuration.getTemplate(),
                configuration.getDefaultName()
        );

        final TemplateHealthCheck healthCheck =
                new TemplateHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("template", healthCheck);

        environment.jersey().register(resource);
    }
}
