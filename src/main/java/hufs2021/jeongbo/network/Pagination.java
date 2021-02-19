package hufs2021.jeongbo.network;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pagination {

    private Integer totalPages;

    private Long totalElements;

    private Integer currentPage;

    private Integer currentElements;
}
