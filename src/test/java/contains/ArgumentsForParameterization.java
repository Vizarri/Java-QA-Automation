package contains;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class ArgumentsForParameterization implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
                Arguments.of("/status/200", 200),
                Arguments.of("/status/300", 300),
                Arguments.of("/status/400", 400),
                Arguments.of("/status/500", 500)
        );
    }
}
