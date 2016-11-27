package de.philipphauer.blog.scaffolding

import de.philipphauer.blog.scaffolding.db.AuthorEntity
import de.philipphauer.blog.scaffolding.db.SnippetEntity
import de.philipphauer.blog.scaffolding.db.SnippetRepository
import de.philipphauer.blog.scaffolding.db.SnippetState
import org.slf4j.LoggerFactory
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import java.time.Instant

@Component
class DummyDataCreator(val repo: SnippetRepository) : ApplicationRunner {

    val LOGGER = LoggerFactory.getLogger(DummyDataCreator::class.java)!!

    override fun run(args: ApplicationArguments) {
        val count = repo.count()
        if (count == 0L){
            LOGGER.info("Inserting dummy data...")
            val entity = SnippetEntity(
                    id = null, //set by db
                    code = "Select * From dual;",
                    date = Instant.now(),
                    state = SnippetState.ACTIVATED,
                    author = AuthorEntity(
                            firstName = "Peter",
                            lastName = "Fischer"
                    )
            )
            repo.insert(entity)
        }
    }
}
