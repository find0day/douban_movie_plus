package org.humingk.movie.dal.domain.douban;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.humingk.movie.dal.entity.AwardMovie;

import java.io.Serializable;

/**
 * 豆瓣电影获得的奖项
 *
 * <p>一部电影可以获得一种奖的多个奖项，故基类放在Movie-Award中
 *
 * @author humingk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AwardOfMovieAndCelebrityDoubanDo implements Serializable {
  private static final long serialVersionUID = 1L;
  // MovieDoubanToAwardMovie -----------------------

  /** 豆瓣电影ID */
  private Long idMovieDouban;

  /** 获奖奖项ID */
  private String idAwardMovie;

  /** 获奖豆瓣影人ID */
  private Long idCelebrityDouban;

  /** 奖项的类别中文名 */
  private String typeAward;

  /** 获奖奖项届数 */
  private Short awardTh;

  /** 是否提名 0-仅提名未获奖 1-已提名且获奖 */
  private Byte isNominated;

  // AwardMovie -----------------------------
  /** 电影奖项 */
  private AwardMovie awardMovie;
}
