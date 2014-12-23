package org.dd4t.core.serializers.impl;

import org.dd4t.core.exceptions.SerializationException;
import org.dd4t.core.serializers.Serializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Factory class to allow easy access for deserialization / serialization
 * of DD4T Tridion Objects.
 * <p/>
 * Needed to hide implementations (JSON, XML)
 * and to have only one instance through the entire application.
 *
 * @Author R. Kempees
 * @Since 06/06/14.
 */
public class SerializerFactory {

    private static final Logger LOG = LoggerFactory.getLogger(SerializerFactory.class);
    private static final SerializerFactory INSTANCE = new SerializerFactory();

	@Autowired
	private Serializer serializer = null;

	private SerializerFactory(){
		LOG.debug("Init SerializerFactory.");
	}

	/**
	 * This is not normally used, but for Unit Testing purposes.
	 *
	 * For normal use, use Spring injection.
	 * @param serializer
	 */
	public static void setSerializer(org.dd4t.core.serializers.Serializer serializer)
	{
		if (INSTANCE != null)
		{
			INSTANCE.serializer = serializer;
		}
	}


	public static SerializerFactory getInstance()
	{
		return INSTANCE;
	}


    /**
     * Deserialize a Tridion DD4T content String.
     *
     * Uses the concrete implementation configured in the context configuration.
     *
     * @param content
     * @param aClass
     * @param <T>     Concrete Type of DD4T model object
     * @return Deserialized DD4T Model Object.
     * @throws SerializationException
     */
    public static <T> T deserialize(String content, Class<T> aClass) throws SerializationException {
        LOG.trace("Using Serializer: {}", INSTANCE.serializer.getClass());
        return INSTANCE.serializer.deserialize(content, aClass);
    }
}