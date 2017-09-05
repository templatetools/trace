package init;

import org.food.safety.trace.repository.MenuDaoTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by tom on 2017/9/5.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses(
        { InitEntity.class, MenuDaoTest.class })
public class Init {
}
