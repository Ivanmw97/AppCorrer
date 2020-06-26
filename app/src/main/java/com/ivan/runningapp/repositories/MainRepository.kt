package com.ivan.runningapp.repositories

import com.ivan.runningapp.db.Run
import com.ivan.runningapp.db.RunDAO
import javax.inject.Inject

class MainRepository @Inject constructor(
    val runDAO: RunDAO
) {
    suspend fun insertRun(run: Run) = runDAO.insertRun(run)
    suspend fun deleteRun(run: Run) = runDAO.deleteRun(run)

    fun getAllRunsSortedByDate() = runDAO.getAllRunsStoredByDate()
    fun getAllRunsSortedByAvgSpeed() = runDAO.getAllRunsStoredByAvgSpeedInKMH()
    fun getAllRunsSortedByDateCaloriesBurned() = runDAO.getAllRunsStoredByCaloriesBurned()
    fun getAllRunsSortedByDistance() = runDAO.getAllRunsStoredByDistanceInMeters()
    fun getAllRunsSortedByTimeInMillis() = runDAO.getAllRunsStoredByTimeInMillis()

    fun getTotalAvgSpeed() = runDAO.getTotalAvgSpeedInKMH()
    fun getTotalCaloriesBurned() = runDAO.getTotalCaloriesBurned()
    fun getTotalDistance() = runDAO.getTotalDistanceInMeters()
    fun getTotalTimesInMillis() = runDAO.getTotalTimeInMillis()
}