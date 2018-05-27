package ai.dogood.flash.cards.domain.entity;

import com.google.gson.annotations.SerializedName;
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

	@SerializedName("source_language")
	private String sourceLanguage;

	@SerializedName("target_language")
	private String targetLanguage;

	@SerializedName("source_word")
	private String sourceWord;

	@SerializedName("target_word")
	private String targetWord;

	private int level;

	public Card(){}

	private Card(final Builder builder) {
		this.uuid = builder.uuid;
		this.sourceLanguage = builder.sourceLanguage;
		this.targetLanguage = builder.targetLanguage;
		this.sourceWord = builder.sourceWord;
		this.targetWord = builder.targetWord;
		this.level = builder.level;
	}

	public static class Builder {
		private String uuid;
		private String sourceLanguage;
		private String targetLanguage;
		private String sourceWord;
		private String targetWord;
		private int level;

		public Builder addUuid(String uuid) {
			this.uuid = uuid;
			return this;
		}

		public Builder sourceLanguage(String sourceLanguage) {
			this.sourceLanguage = sourceLanguage;
			return this;
		}

		public Builder targetLanguage(String targetLanguage) {
			this.targetLanguage = targetLanguage;
			return this;
		}

		public Builder sourceWord(String sourceWord) {
			this.sourceWord = sourceWord;
			return this;
		}

		public Builder targetWord(String targetWord) {
			this.targetWord = targetWord;
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