package org.allurefw.report;

import com.google.inject.Guice;
import org.junit.Test;

import java.nio.file.Paths;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.mockito.Mockito.mock;

/**
 * @author charlie (Dmitry Baev).
 */
public class ReportFactoryTest {

    @Test
    public void shouldCreateReport() throws Exception {
        @SuppressWarnings("unchecked")
        List<Plugin> plugins = (List<Plugin>) mock(List.class);
        ReportFactory factory = Guice.createInjector(new ParentModule(plugins))
                .getInstance(ReportFactory.class);

        ResultsSource source = new FileSystemResultsSource(Paths.get("/Users/charlie/projects/allure-report/generator/src/test/resources/allure1data"));
        Report report = factory.create(source);

        assertThat(report, notNullValue());
    }
}
