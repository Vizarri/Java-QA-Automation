package tests;


import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class ArgumentsForParameterization implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
                Arguments.of("//div[@id='block_top_menu']//a[@title='Women']", "span.cat-name", "women"),
                Arguments.of("//div[@id='block_top_menu']//a[@title='Dresses' and ./following-sibling::ul[contains(@Class, 'submenu-container')]]", "span.cat-name", "dresses"),
                Arguments.of("//div[@id='block_top_menu']//li[3]/a[@title='T-shirts']  ", "span.cat-name", "t-shirts")
        );
    }
}
