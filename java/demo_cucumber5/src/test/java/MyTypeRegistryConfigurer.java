import io.cucumber.core.api.TypeRegistry;
import io.cucumber.core.api.TypeRegistryConfigurer;
import io.cucumber.cucumberexpressions.ParameterType;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MyTypeRegistryConfigurer implements TypeRegistryConfigurer {
    @Override
    public Locale locale() {
        return null;
    }

    @Override
    public void configureTypeRegistry(TypeRegistry registry) {
        ParameterType<Date> parameterType = new ParameterType<>(
                "oldIsoDate",
                "\\d{4}-\\d{2}-\\d{2}",
                Date.class,
                (String s) -> new SimpleDateFormat("yyyy-mm-dd").parse(s)
        );
        registry.defineParameterType(parameterType);

        // registry.defineParameterType(CommonParameterTypes.getDependencyParamType());
    }
}