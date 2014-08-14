package org.mu.opencomm.code.repository;

import org.mu.opencomm.code.entity.NCSALog;
import org.mu.opencomm.common.repository.AbstractRepository;
import org.springframework.stereotype.Repository;

@Repository("ncsaLogRepository")
public class NCSALogRepository extends AbstractRepository<NCSALog, String> {

}
