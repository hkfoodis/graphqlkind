package org.zerock.graphql;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zerock.graphql.entity.Kind;
import org.zerock.graphql.query.Query;

import com.apollographql.federation.graphqljava.Federation;
import com.apollographql.federation.graphqljava._Entity;
import com.coxautodev.graphql.tools.SchemaParser;

import graphql.schema.GraphQLSchema;

@Configuration
public class GraphQLConfig {

	@Bean
	public GraphQLSchema customSchema(SchemaParser schemaParser, Query query) {
		return Federation.transform(schemaParser.makeExecutableSchema())
				.fetchEntities(env -> env.<List<Map<String, Object>>>getArgument(_Entity.argumentName)
						.stream()
						.map(values -> {
							if ("Kind".equals(values.get("__typename"))) {
								final Object id = values.get("name");
								if (id instanceof String) {
									return query.kind((String) id);
								}
							}
							return null;
						})
						.collect(Collectors.toList()))
				.resolveEntityType(env -> {
					final Object src = env.getObject();
					if (src instanceof Kind) {
						return env.getSchema().getObjectType("Kind");
					}
					return null;
				})
				.build();
	}
}
