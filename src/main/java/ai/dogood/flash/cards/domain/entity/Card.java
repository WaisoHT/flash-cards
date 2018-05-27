package ai.dogood.flash.cards.domain.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "card")
public class Card implements Serializable {

	private static final long serialVersionUID = -2022247876565735211L;

	@Id
    private String id;

	@Indexed(unique = true)
	private String uuid;

	@JsonProperty("language-origin")
	private String languageOrigin;

	@JsonProperty("language-destiny")
	private String languageDestiny;

	@JsonProperty("value-origin")
	private String valueOrigin;

	@JsonProperty("value-destiny")
	private String valueDestiny;

	private int level;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getLanguageOrigin() {
		return languageOrigin;
	}

	public void setLanguageOrigin(String languageOrigin) {
		this.languageOrigin = languageOrigin;
	}

	public String getLanguageDestiny() {
		return languageDestiny;
	}

	public void setLanguageDestiny(String languageDestiny) {
		this.languageDestiny = languageDestiny;
	}

	public String getValueOrigin() {
		return valueOrigin;
	}

	public void setValueOrigin(String valueOrigin) {
		this.valueOrigin = valueOrigin;
	}

	public String getValueDestiny() {
		return valueDestiny;
	}

	public void setValueDestiny(String valueDestiny) {
		this.valueDestiny = valueDestiny;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public Card(){}

	private Card(final Builder builder) {
		this.uuid = builder.uuid;
		this.languageOrigin = builder.languageOrigin;
		this.languageDestiny = builder.languageDestiny;
		this.valueOrigin = builder.valueOrigin;
		this.valueDestiny = builder.valueDestiny;
		this.level = builder.level;
	}

	public static class Builder {
		private String uuid;
		private String languageOrigin;
		private String languageDestiny;
		private String valueOrigin;
		private String valueDestiny;
		private int level;

		public Builder uuid(String uuid) {
			this.uuid = uuid;
			return this;
		}

		public Builder languageOrigin(String languageOrigin) {
			this.languageOrigin = languageOrigin;
			return this;
		}

		public Builder languageDestiny(String languageDestiny) {
			this.languageDestiny = languageDestiny;
			return this;
		}

		public Builder valueOrigin(String valueOrigin) {
			this.valueOrigin = valueOrigin;
			return this;
		}

		public Builder valueDestiny(String valueDestiny) {
			this.valueDestiny = valueDestiny;
			return this;
		}

		public Builder level(int level) {
			this.level = level;
			return this;
		}

		public Card build() {
			return new Card(this);
		}
	}

}