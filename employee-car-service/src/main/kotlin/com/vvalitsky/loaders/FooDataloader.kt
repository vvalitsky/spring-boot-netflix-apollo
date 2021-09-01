package com.vvalitsky.loaders

import com.netflix.graphql.dgs.DgsDataLoader
import com.vvalitsky.entities.EmployeeCar
import org.dataloader.MappedBatchLoader
import java.util.concurrent.CompletionStage

@DgsDataLoader(name = "foo")
class FooDataloader : MappedBatchLoader<String, EmployeeCar> {
    override fun load(keys: MutableSet<String>?): CompletionStage<MutableMap<String, EmployeeCar>> {
        TODO("Not yet implemented")
    }
}
