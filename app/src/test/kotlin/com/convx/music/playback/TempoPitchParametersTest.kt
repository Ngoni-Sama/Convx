package com.convx.music.playback

import org.junit.Assert.assertEquals
import org.junit.Test

class TempoPitchParametersTest {
    @Test
    fun keepsTheUsersTempoAndPitchWithoutACorrection() {
        val parameters = tempoPitchParameters(tempo = 1.25f, pitch = 1.5f)

        assertEquals(1.25f, parameters.speed, DELTA)
        assertEquals(1.5f, parameters.pitch, DELTA)
    }

    @Test
    fun rateCorrectionChangesTempoButNotPitch() {
        val parameters = tempoPitchParameters(tempo = 1.25f, pitch = 0.75f, rateCorrection = 1.2)

        assertEquals(1.5f, parameters.speed, DELTA)
        assertEquals(0.75f, parameters.pitch, DELTA)
    }

    private companion object {
        const val DELTA = 0.0001f
    }
}
