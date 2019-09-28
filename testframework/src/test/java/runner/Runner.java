package runner;

import java.util.Arrays;
import java.util.List;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.embedder.EmbedderControls;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.core.steps.PrintStreamStepMonitor;
import org.junit.runner.RunWith;
import reporter.JbehaveStoryReporter;
import stepdefinitions.*;
import com.github.valfirst.jbehave.junit.monitoring.JUnitReportingRunner;

@RunWith(JUnitReportingRunner.class)
public class Runner extends JUnitStories {
        /**
         * Initialize JUnitStoryRunner with {@linkplain Embedder} configuration
         * and meta filters (can be read from System property {@code metaFilters})
         */
        public Runner() {
            super();
            Embedder embedder = configuredEmbedder();
            String metaFilters = "googleSearch";
            embedder.useMetaFilters(Arrays.asList(metaFilters));

            EmbedderControls embedderControls = embedder.embedderControls();
            embedderControls.doIgnoreFailureInStories(true);
            embedderControls.doIgnoreFailureInView(true);
        }

        @Override
        public Configuration configuration() {
            return new MostUsefulConfiguration().useStoryLoader(new LoadFromClasspath(this.getClass().getClassLoader()))
                    .useStepMonitor(new PrintStreamStepMonitor())
                    .useStoryReporterBuilder(new StoryReporterBuilder()
                            .withDefaultFormats()
                            .withFormats(Format.HTML, Format.CONSOLE, Format.TXT, Format.XML)
                            .withReporters(new JbehaveStoryReporter())
                            .withRelativeDirectory("logs"));
        }

        @Override
        public InjectableStepsFactory stepsFactory() {
            return new InstanceStepsFactory(configuration(), new StepDefinitions());
        }

        @Override
        protected List<String> storyPaths() {
            return new StoryFinder().findPaths(CodeLocations.codeLocationFromClass(this.getClass()), Arrays.asList("**/*.story"), Arrays.asList(""));
        }

}
