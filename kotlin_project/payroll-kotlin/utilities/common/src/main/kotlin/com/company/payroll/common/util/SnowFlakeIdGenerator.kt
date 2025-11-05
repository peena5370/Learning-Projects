package com.company.payroll.common.util


class SnowFlakeIdGenerator(dataCenterId: Long, workerId: Long)
{
    companion object
    {
        // start time stamp initialized at 2023-05-15 12:00:00
        private const val START_TIMESTAMP = 1684123200000L
        private const val SEQUENCE_BIT = 12L
        private const val WORKER_ID_BIT = 5L
        private const val DATA_CENTER_ID_BIT = 5L
        private const val MAX_DATA_CENTER_ID = (- 1L shl DATA_CENTER_ID_BIT.toInt()).inv()
        private const val MAX_WORKER_ID = (- 1L shl WORKER_ID_BIT.toInt()).inv()
        private const val MAX_SEQUENCE = (- 1L shl SEQUENCE_BIT.toInt()).inv()
        private const val WORKER_ID_SHIFT = SEQUENCE_BIT
        private const val DATA_CENTER_ID_SHIFT = SEQUENCE_BIT + WORKER_ID_BIT
        private const val TIMESTAMP_LEFT_SHIFT = SEQUENCE_BIT + WORKER_ID_BIT + DATA_CENTER_ID_BIT
    }

    // 0 ~ 31 number for dataCenterId and workerId
    private val dataCenterId: Long
    private val workerId: Long
    private var sequence = 0L
    private var lastTimestamp = - 1L

    init
    {
        require(! (dataCenterId > MAX_DATA_CENTER_ID || dataCenterId < 0)) { "dataCenterId can't be greater than MAX_DATA_CENTER_ID or less than 0" }
        require(! (workerId > MAX_WORKER_ID || workerId < 0)) { "workerId can't be greater than MAX_WORKER_ID or less than 0" }
        this.dataCenterId = dataCenterId
        this.workerId = workerId
    }

    @Synchronized
    fun nextId(): Long
    {
        var currentTimestamp = generateNewTimestamp()
        if (currentTimestamp < lastTimestamp)
        {
            throw RuntimeException("Clock moved backwards.  Refusing to generate id")
        }
        if (currentTimestamp == lastTimestamp)
        {
            sequence = sequence + 1 and MAX_SEQUENCE
            if (sequence == 0L)
            {
                currentTimestamp = getNextMill(lastTimestamp)
            }
        }
        else
        {
            sequence = 0L
        }
        lastTimestamp = currentTimestamp
        return currentTimestamp - START_TIMESTAMP shl TIMESTAMP_LEFT_SHIFT.toInt() or (dataCenterId shl DATA_CENTER_ID_SHIFT.toInt()) or (workerId shl WORKER_ID_SHIFT.toInt()) or sequence
    }

    protected fun getNextMill(lastTimestamp: Long): Long
    {
        var mill = generateNewTimestamp()
        while (mill <= lastTimestamp)
        {
            mill = generateNewTimestamp()
        }
        return mill
    }

    private fun generateNewTimestamp(): Long
    {
        return System.currentTimeMillis()
    }


}