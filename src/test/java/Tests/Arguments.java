package Tests;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class Arguments implements ArgumentsProvider {
    @Override
    public Stream<? extends org.junit.jupiter.params.provider.Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
                org.junit.jupiter.params.provider.Arguments.of("//div[@id='block_top_menu']//a[@title='Women']", "span.cat-name", "women"),
                org.junit.jupiter.params.provider.Arguments.of("//div[@id='block_top_menu']/ul/li[2]/a[@title='Dresses']", "span.cat-name", "dresses"),
                org.junit.jupiter.params.provider.Arguments.of("//div[@id='block_top_menu']//li[3]/a[@title='T-shirts']  ", "span.cat-name", "t-shirts")
        );
    }
}
