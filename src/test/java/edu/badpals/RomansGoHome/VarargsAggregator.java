package edu.badpals.RomansGoHome;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregationException;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;
import org.junit.platform.commons.util.Preconditions;

import java.lang.reflect.Array;
import java.util.stream.IntStream;

// Taken from: https://github.com/junit-team/junit5/issues/2256#issuecomment-612438057
class VarargsAggregator implements ArgumentsAggregator {
	@Override
	public Object aggregateArguments(ArgumentsAccessor accessor, ParameterContext context) throws ArgumentsAggregationException {
		Class<?> parameterType = context.getParameter().getType();
		Preconditions.condition(parameterType.isArray(), () -> "must be an array type, but was " + parameterType);
		Class<?> componentType = parameterType.getComponentType();
		return IntStream.range(context.getIndex(), accessor.size())
				.mapToObj(index -> accessor.get(index, componentType))
				.toArray(size -> (Object[]) Array.newInstance(componentType, size));
	}
}