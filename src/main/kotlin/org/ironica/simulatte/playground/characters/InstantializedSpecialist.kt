/*
 * Copyright (c) 2020-2021. kokoro-aya. All right reserved.
 * Simulatte - A Playground Server implemented with Kotlin DSL
 *
 * This program is free software: you can redistribute it and/or modify it under the terms of the GNU Affero General Public License as published by the Free Software Foundation, either version 3 of the License, or any later version.
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Affero General Public License for more details.
 * You should have received a copy of the GNU Affero General Public License along with this program. If not, see <https://www.gnu.org/licenses/>.
 *
 */

package org.ironica.simulatte.playground.characters

import org.ironica.simulatte.bridge.LockData
import org.ironica.simulatte.playground.Direction
import org.ironica.simulatte.playground.Playground
import utils.StringRepresentable

data class InstantializedSpecialist(override val id: Int, override var dir: Direction, override var stamina: Int): AbstractCharacter, StringRepresentable {

    override var playground: Playground? = null

    override var collectedGem = 0
    override var beeperInBag = 0

    override var inWaterForTurns: Int = 0
    override var inLavaForTurns: Int = 0

    fun isBeforeLock() = playground?.specialistIsBeforeLock(this) ?: NullPointerException("Specialist:: Uninitialized character")

    fun turnLockUp() = playground?.specialistTurnLockUp(this) ?: NullPointerException("Specialist:: Uninitialized character")

    fun turnLockDown() = playground?.specialistTurnLockDown(this) ?: NullPointerException("Specialist:: Uninitialized character")

    override val stringRepresentation: String
        get() = "Specialist($id, $dir, $stamina)"
}